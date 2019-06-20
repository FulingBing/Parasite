package com.github.FulingBing;

import com.github.FulingBing.pojo.ParasitePlayer;
import com.github.FulingBing.service.ParasiteCore;

public class ParasiteAPI {
	//���ù���ȼ�
	public static void setPlayerParasiteHookworm(String name,int num) {
		(new ParasiteCore()).setState(name, 0, num, false);
	}
	//���û׳�ȼ�
	public static void setPlayerParasiteRoundworm(String name,int num) {
		(new ParasiteCore()).setState(name, 1, num, false);
	}
	//����Ѫ����ȼ�
	public static void setPlayerParasiteSchistosome(String name,int num) {
		(new ParasiteCore()).setState(name, 2, num, false);
	}
	//�����г�ȼ�
	public static void setPlayerParasiteTapeworm(String name,int num) {
		(new ParasiteCore()).setState(name, 3, num, false);
	}
	//���ù��γ�ȼ�
	public static void setPlayerParasiteToxoplasma(String name,int num) {
		(new ParasiteCore()).setState(name, 4, num, false);
	}
	//����űԭ��ȼ�
	public static void setPlayerParasitePlasmodium(String name,int num) {
		(new ParasiteCore()).setState(name, 5, num, false);
	}
	//��ѯ����ȼ�
	public static int getPlayerParasiteHookworm(String name) {
		return getParasiteTime(name,0,false);
	}
	//��ѯ�׳�ȼ�
	public static int getPlayerParasiteRoundworm(String name) {
		return getParasiteTime(name,1,false);
	}
	//��ѯѪ����ȼ�
	public static int getPlayerParasiteSchistosome(String name) {
		return getParasiteTime(name,2,false);
	}
	//��ѯ�г�ȼ�
	public static int getPlayerParasiteTapeworm(String name) {
		return getParasiteTime(name,3,false);
	}
	//��ѯ���γ�ȼ�
	public static int getPlayerParasiteToxoplasma(String name) {
		return getParasiteTime(name,4,false);
	}
	//��ѯűԭ��ȼ�
	public static int getPlayerParasitePlasmodium(String name) {
		return getParasiteTime(name,5,false);
	}
	//����֢
	public static void setPlayerParasiteHookwormSequela(String name,int num) {
		(new ParasiteCore()).setState(name, 0, num, true);
	}
	public static void setPlayerParasiteRoundwormSequela(String name,int num) {
		(new ParasiteCore()).setState(name, 1, num, true);
	}
	public static void setPlayerParasiteSchistosomeSequela(String name,int num) {
		(new ParasiteCore()).setState(name, 2, num, true);
	}
	public static void setPlayerParasiteTapewormSequela(String name,int num) {
		(new ParasiteCore()).setState(name, 3, num, true);
	}
	public static void setPlayerParasiteToxoplasmaSequela(String name,int num) {
		(new ParasiteCore()).setState(name, 4, num, true);
	}
	public static void setPlayerParasitePlasmodiumSequela(String name,int num) {
		(new ParasiteCore()).setState(name, 5, num, true);
	}
	public static int getPlayerParasiteHookwormSequela(String name) {
		return getParasiteTime(name,0,true);
	}
	public static int getPlayerParasiteRoundwormSequela(String name) {
		return getParasiteTime(name,1,true);
	}
	public static int getPlayerParasiteSchistosomeSequela(String name) {
		return getParasiteTime(name,2,true);
	}
	public static int getPlayerParasiteTapewormSequela(String name) {
		return getParasiteTime(name,3,true);
	}
	public static int getPlayerParasiteToxoplasmaSequela(String name) {
		return getParasiteTime(name,4,true);
	}
	public static int getPlayerParasitePlasmodiumSequela(String name) {
		return getParasiteTime(name,5,true);
	}
	
	private static int getParasiteTime(String name,int type,boolean hyz) {
		for(ParasitePlayer tpp:ParasiteData.userinfo) {
			if(tpp.name.equals(name)) {
				if(hyz) {
					return tpp.sequela[type];
				}else {
					return tpp.time[type];
				}
			}
		}
		return 0;
	}
}
