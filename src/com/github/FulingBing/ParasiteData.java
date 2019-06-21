package com.github.FulingBing;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.plugin.Plugin;

import com.github.FulingBing.pojo.ParasitePlayer;
import com.github.FulingBing.pojo.ParasiteState;

public class ParasiteData {
	public static String[] ParasiteName={"����","�׳�","Ѫ����","�г�","���γ�","űԭ��"};//�����������

	//public static FileConfiguration data;//��ҵ������ļ�
	public static File file;//��ҵ������ļ�
	public static List<ParasitePlayer> userinfo=new ArrayList<ParasitePlayer>();//��ҵĸ�Ⱦ��Ϣ
	public static List<ParasiteState> userstate=new ArrayList<ParasiteState>();//��ҵ�״̬��Ϣ
	public static List<String> noParasite=new ArrayList<String>();//Ԥ��
	public static int runtime_1;//ѭ������
	public static int runtime_5;//ѭ������
	public static int runtime_300;//ѭ������
	
	public static Plugin plugin;
	
	public static double ItemProbability;//��Ⱦ���ʣ���Ʒ��
	public static double LocProbability;//��Ⱦ���ʣ��ط���
	public static double Misdiagnosis;//���Ｘ��
	
	public static boolean DeathClear;//�������Ƿ������Ⱦ
	public static List<String> RawFool=new ArrayList<String>();//����ʳ��
	public static List<String> DirtyFool=new ArrayList<String>();//����/���õ�ʳ��
	public static List<String> BotanyFool=new ArrayList<String>();//ˮ��ˮ�����߲�
	public static List<String> Entity=new ArrayList<String>();//ʵ��
	public static List<String> OceanBiomes=new ArrayList<String>();//����
	public static List<String> DampBiomes=new ArrayList<String>();//��ů��ʪ�ĵط�
	public static List<String> Water=new ArrayList<String>();//ˮԴ
	
	private static String typeGLASS_PANE=null;
	private static String typeCOMPARATOR=null;
	private static String typeSNOWBALL=null;
	private static String typeWHEAT_SEEDS=null;
	public static String fuckBukkit(int fuck) {
		if(typeGLASS_PANE==null) {
			Material[] lm=Material.values();
			for(Material m:lm) {
				if(m.name().equals("COMPARATOR")) {
					typeGLASS_PANE="GLASS_PANE";
					typeCOMPARATOR="COMPARATOR";
					typeSNOWBALL="SNOWBALL";
					typeWHEAT_SEEDS="WHEAT_SEEDS";
					break;
				}
			}
		}
		if(typeGLASS_PANE==null) {
			typeGLASS_PANE="STAINED_GLASS_PANE";
			typeCOMPARATOR="REDSTONE_COMPARATOR";
			typeSNOWBALL="SNOW_BALL";
			typeWHEAT_SEEDS="SEEDS";
		}
		switch (fuck) {
		case 0:
			return typeGLASS_PANE;
		case 1:
			return typeCOMPARATOR;
		case 2:
			return typeSNOWBALL;
		default:
			return typeWHEAT_SEEDS;
		}
	}
	
	//��Ʒ
	public static String getItemCureName() {
		return "��b����������ҩ�� ��c";
	}
	public static String getItemHpName() {
		return "��c�Թ� ��d[��bѪҺ������d]";
	}
	public static String getItemFoName() {
		return "��c�Թ� ��d[��b���������d]";
	}
	public static String getItemLoName() {
		return "��a���������";
	}
	public static String getItemNoName() {
		return "��b������Ԥ��ҩ��";
	}
	public static String getItemBtName() {
		return "��e������";
	}
	public static List<String> getItemCureLore() {
		List<String> re=new ArrayList<String>();
		re.add("��a��һ���̶��ϼ������ڼ����������");
		re.add("��e��δ��Ⱦ��Ӧ�ļ����棬����ô�ҩ���ж�");
		re.add("��b�������");
		return re;
	}
	public static List<String> getItemHpLore() {
		List<String> re=new ArrayList<String>();
		re.add("��a�յ�");
		re.add("��e����1������ֵ,�Ա�������װ��ѪҺ");
		re.add("��b���ʹ��");
		return re;
	}
	public static List<String> getItemFoLore() {
		List<String> re=new ArrayList<String>();
		re.add("��a�յ�");
		re.add("��e����1�㼢����,�Ա�������װ����");
		re.add("��b���ʹ��");
		return re;
	}
	public static List<String> getItemLoreUse(String name) {
		List<String> re=new ArrayList<String>();
		re.add("��a"+name);
		re.add("��e���: ��d"+(new Date()).getTime());
		re.add("��bǧ�����ⶫ������");
		return re;
	}
	public static List<String> getItemLoLore() {
		List<String> re=new ArrayList<String>();
		re.add("��d�������������");
		re.add("��b����򿪼�����");
		return re;
	}
	public static List<String> getItemNoLore() {
		List<String> re=new ArrayList<String>();
		re.add("��a�ɶ�ʱ���ڼ��ٸ�Ⱦ������ļ���");
		re.add("��e����ʱ������ţ�ҩЧ���𽥼���");
		re.add("��b�������");
		return re;
	}
	public static List<String> getItemBtLore() {
		List<String> re=new ArrayList<String>();
		re.add("��a��С���ȼ��ٳ����ڵļ����������");
		re.add("��e����Ⱦ�̶ȷ�չ�����׶Σ���ҩЧ΢����΢");
		re.add("��b�������");
		return re;
	}
	
	//GUI
	public static String getGUITitle() {
		return "��9���������";
	}
}
