package com.github.FulingBing.service;

import java.util.Collection;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.github.FulingBing.ParasiteData;
import com.github.FulingBing.pojo.ParasitePlayer;
import com.github.FulingBing.pojo.ParasiteState;

public class ParasiteRun extends TimerTask{
	@Override
	public void run() {
		Collection<? extends Player> plist=Bukkit.getOnlinePlayers();
		if(plist.isEmpty()) {
			return;
		}
		ParasiteCore pc=new ParasiteCore();
		//0.5���ѭ������
		//����������ҵ�Ѫ���ͱ�ʳ��
		Bukkit.getServer().getScheduler().runTaskLater(ParasiteData.plugin ,new Runnable() {
			@Override
			public void run() {
				(new ParasiteCore()).setAllHpFool();
			}
		},1);
		//1���ѭ������
		ParasiteData.runtime_1++;
		if(ParasiteData.runtime_1>1) {
			ParasiteData.runtime_1=0;
			//��Ⱦűԭ���Ѫ����
			for(Player pl:plist) {
				if(((int)(Math.random()*100))>=pc.getNoParas(pl.getName())) {
					pc.getParasiteByLoc(pl);
				}
			}
		}
		//5���ѭ������
		ParasiteData.runtime_5++;
		if(ParasiteData.runtime_5>9) {
			ParasiteData.runtime_5=0;
			//�����û�״̬
			if(!ParasiteData.userstate.isEmpty()) {
				ParasiteData.userstate.clear();
			}
			for(Player pl:plist) {
				String name=pl.getName();
				ParasitePlayer pp=null;
				for(int i=0;i<ParasiteData.userinfo.size();i++) {
					ParasitePlayer tpp=ParasiteData.userinfo.get(i);
					if(tpp.name.equals(name)) {
						if((tpp.time[0]+tpp.time[1]+tpp.time[2]+tpp.time[3]+tpp.time[4]+tpp.time[5]==0 
								&& tpp.sequela[0]+tpp.sequela[1]+tpp.sequela[2]+tpp.sequela[3]+tpp.sequela[4]+tpp.sequela[5]==0) 
								|| pl.hasPermission("Parasite.pass")) {
							ParasiteData.userinfo.remove(i);
						}else{
							pp=tpp;
							for(int j=0;j<6;j++) {
								if(pp.time[j]!=0 && pp.time[j]<30000) {
									pp.time[j]+=5;
								}
							}
							ParasiteData.userinfo.set(i,pp);
						}
						continue;
					}
				}
				if(pp==null) {
					continue;
				}
				ParasiteState ps=pc.getState(pp,pl);
				ps.effect=pc.getEffect(ps);
				ParasiteData.userstate.add(ps);
			}
			//����״̬
			if(!ParasiteData.userstate.isEmpty()) {
				Bukkit.getServer().getScheduler().runTaskLater(ParasiteData.plugin ,new Runnable() {
					@Override
					public void run() {
						ParasiteCore pc=new ParasiteCore();
						for(ParasiteState ps:ParasiteData.userstate) {
							if(ps.effect!=null) {
								pc.setEffect(ps);
							}
						}
					}
				},1);
			}
			//Ԥ��
			for(int i=0;i<ParasiteData.noParasite.size();i++) {
				String[] str=ParasiteData.noParasite.get(i).split(",");
				int k=Integer.parseInt(str[1]);
				if(k<2) {
					ParasiteData.noParasite.remove(i);
					i--;
				}else {
					k--;
					ParasiteData.noParasite.set(i, str[0]+","+k);
				}
			}
		}
		//5���ӵ�ѭ������
		ParasiteData.runtime_300++;
		if(ParasiteData.runtime_300>599) {
			ParasiteData.runtime_300=0;
			//�����������
			ParasiteCore.saveUserData();
		}
	}
}
