/**
 * 
 */
package cn.droidlover.xrichtext;

import java.io.IOException;
import java.util.List;

import me.solidev.getwordtextview.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

/**
 * @author wenxiang.lv
 *
 */
public class XRichTextActivity extends Activity {
	  XRichText richText;

	    private static final String TEXT = "<div class=\"BlogContent\"><p><span style=\"font-size: 14px;\"><strong>��λ OSCer ��Һ����ܶ��ˣ����ǵ���һ�ۺ�֢���˰ɣ�û���͵���˰ɣ��Ͻ��ϰ�ȥ�ɣ��ܶ�������Ľ��������</strong></span></p><p><span style=\"font-size: 14px;\"></span></p><p><a href=\"http://my.oschina.net/u/1756518\" target=\"_blank\" rel=\"nofollow\">@����һƷ��</a><span style=\"font-size: 14px;\">��ÿ�쿴���Ƿ�˵˵���Ҷ�����Ľ �����ǳ����ֺÿ� �����������ֻ�������Ǯ &nbsp;\n" +
	            "����������һЩ����������Ķ���������ø����������Ҽ����µ�����ѣ��Ҷ����٣������������ģ�û�����������棬������ֻ��ĬĬ�Ŀ����㷢��ʱ��ʱ�����\n" +
	            " , ����������Լ�װ�����Ǻ��� ����� ���ĺ��� �����˲�˵�� �����˴��Ұ��ֻ�����������Ҫȥι����&nbsp;\t </span></p><p><span style=\"font-size: 14px;\"><strong><strong>��λ���ѣ�������������ů����˵��������Щ��ש�ĺ�����Ҹ������ӣ�</strong></strong></span></p><p><a href=\"http://static.oschina.net/uploads/space/2015/0720/172817_huYO_2359467.jpg\" target=\"_blank\"><img title=\"\" src=\"http://static.oschina.net/uploads/space/2015/0720/172817_huYO_2359467.jpg\" height=\"197\" width=\"250\" style=\"cursor: pointer;\"></a></p><p><span style=\"font-size: 14px;\"><strong>�ϰ�·�ϻ����Ѿ�����񽭺��ն񣬵������ǻ��ˡ���</strong></span></p><p><span style=\"font-size: 14px;\"></span><a href=\"http://my.oschina.net/u/1421895\" target=\"_blank\" rel=\"nofollow\">@everlxq</a><span style=\"font-size: 14px;\">���ڽ��Ͼ���������͵͵����Ҫ��Ҫ�ֻ��ģ�����̫�����ˣ�ֱ����Ŀ�ŵ��������������ˣ��ղ���·��������һŮ�ģ���û���ü�˵�Բ�����Ů�ľ�Ȼ��������Ҫ��Ҫ����&nbsp;\t </span></p><p><span style=\"font-size: 14px;\"></span></p><p><a href=\"http://my.oschina.net/u/1397000\" target=\"_blank\" rel=\"nofollow\">@Sonnet</a><span style=\"font-size: 14px;\">���������������ڹ�������վ�����и����ε��ˣ�û���������ң��走��һ�������˶�û��... <br></span></p><p><span style=\"font-size: 14px;\"><strong>�ⲻ�ֱܹ��ˣ������㿴������80�꣬�˼Ҳ��ҷ����������С��ֽ�Ͳ�ͬ��</strong></span></p><p><a href=\"http://my.oschina.net/blindcat\" target=\"_blank\" rel=\"nofollow\">@blindcat</a><span style=\"font-size: 14px;\">��������߯����</span></p><p><a href=\"http://static.oschina.net/uploads/space/2015/0720/160557_Bw9o_31384.gif\" target=\"_blank\"><img title=\"\" alt=\"http://static.oschina.net/uploads/space/2015/0720/160557_Bw9o_31384.gif\" src=\"http://static.oschina.net/uploads/space/2015/0720/160557_Bw9o_31384.gif\" height=\"175\" width=\"280\" style=\"cursor: pointer;\"></a></p><p><a href=\"http://my.oschina.net/riaway\" target=\"_blank\" rel=\"nofollow\">@OSC��ϯ������</a><span style=\"font-size: 14px;\">���������ĺ�ɫ��Դ�ڿ㣬�������İ�ɫ��ԴT��������ˬ�ĸо� <br></span></p><p><a href=\"http://my.oschina.net/fengxh\" target=\"_blank\" rel=\"nofollow\">@�ܶ�����ȸ</a><span style=\"font-size: 14px;\">���칫������ܲ���&nbsp;\t <br></span></p><p><a href=\"http://my.oschina.net/oscfox\" target=\"_blank\" rel=\"nofollow\">@Yashin</a><span style=\"font-size: 14px;\">����˾������������ʱ���Ǵ������&nbsp;\t <br></span></p><p><span style=\"font-size: 14px;\"><strong>�����յ����ȣ����˿յ������䣬���ˣ��Լ���һ̨���Ȱ�</strong></span></p><p><a href=\"http://static.oschina.net/uploads/space/2015/0720/172817_3dT8_2359467.jpg\" target=\"_blank\"><img title=\"\" src=\"http://static.oschina.net/uploads/space/2015/0720/172817_3dT8_2359467.jpg\" height=\"357\" width=\"300\" style=\"cursor: pointer;\"></a></p><p><span style=\"font-size: 14px;\"><strong>Ͷ���깫˾�������͸��²����쵼��</strong></span></p><p><a href=\"http://my.oschina.net/u/2315272\" target=\"_blank\" rel=\"nofollow\">@VNC</a><span style=\"font-size: 14px;\">�������쵼͵��Ա��QQ�����¼����TM������� <br></span></p><p><span style=\"font-size: 14px;\"><strong>̫�ɶ��ˣ�СС�������ô�Ը��쵼</strong><br></span></p><p><a href=\"http://static.oschina.net/uploads/space/2015/0720/171718_mi31_2359467.jpg\" target=\"_blank\"><img title=\"\" src=\"http://static.oschina.net/uploads/space/2015/0720/171718_mi31_2359467.jpg\" height=\"500\" width=\"300\" style=\"cursor: pointer;\"></a></p><p><span style=\"font-size: 14px;\"><strong>������񹤵Ļ���һ���������Ͼ͵��¸���û��ϵ��СС�������ܺù�������</strong><br></span></p><p><a href=\"http://my.oschina.net/maimu\" target=\"_blank\" rel=\"nofollow\">@�@�</a><span style=\"font-size: 14px;\">����н50�򣬹��������ɡ�</span></p><p><a href=\"http://static.oschina.net/uploads/space/2015/0720/150705_dLJI_135555.jpg\" target=\"_blank\"><img title=\"\" alt=\"http://static.oschina.net/uploads/space/2015/0720/150705_dLJI_135555.jpg\" src=\"http://static.oschina.net/uploads/space/2015/0720/150705_dLJI_135555.jpg\" height=\"169\" width=\"300\" style=\"cursor: pointer;\"></a></p><p><span style=\"font-size: 14px;\"><strong>��Ȼ�������������ͻȻ����Ǯ�ˣ������������ײ���ˣ��Ǿ���Ŀ��ܲ��ù����ˡ�</strong><br></span></p><p><a href=\"http://my.oschina.net/lahong\" target=\"_blank\" rel=\"nofollow\">@��ͤ����</a><span style=\"font-size: 14px;\">��һ��ү��ATM��ȡ400Ԫ�³�4000Ԫ�����нд�ү��Ǯ��֮�������յ���λ��үһ����ţ���������</span></p><p><a href=\"http://static.oschina.net/uploads/space/2015/0720/151552_SYta_616610.png\" target=\"_blank\"><img title=\"\" alt=\"http://static.oschina.net/uploads/space/2015/0720/151552_SYta_616610.png\" src=\"http://static.oschina.net/uploads/space/2015/0720/151552_SYta_616610.png\" height=\"388\" width=\"400\" style=\"cursor: pointer;\"></a></p><p><span style=\"font-size: 14px;\"><strong>�����������������й��𣿲�Ҫƭ�ң����й��Ļ�����ү�ַ��ӱ�ץȥ�׺��Ӱ���</strong></span></p><p><span style=\"font-size: 14px;\"><strong>��������������Ⱥ�������ǲ��𣬻����������ߵ�ͬ�º��ˡ���</strong><br></span></p><p><a href=\"http://my.oschina.net/mrzhao\" target=\"_blank\" rel=\"nofollow\">@��ɽ��</a><span style=\"font-size: 14px;\">���Ա�����һɵ�ƣ���������ĳ��裬�ϰ೪�裬����������&nbsp; <br></span></p><p><span style=\"font-size: 14px;\"><strong>����Ǹ������ڳ��裬�㻹�������𣬹����㶼�쳤����͵�����˼��ˡ�����</strong></span></p><p><a href=\"http://my.oschina.net/u/2295077\" target=\"_blank\" rel=\"nofollow\">@����ʧ���</a><span style=\"font-size: 14px;\">���������������Ͽ��ڿ㣬��˿�Ķ��һ��������Ǽ�����˼����ô���������˻������ɿ㣬��������Ц������<br></span></p><p><a href=\"http://my.oschina.net/npxiaoqiang\" target=\"_blank\" rel=\"nofollow\">@npСǿ</a><span style=\"font-size: 14px;\">����Ұ�������Զ�û�ˣ��ؼ�������ֽ�������ϸ�����</span></p><p><a href=\"http://static.oschina.net/uploads/space/2015/0720/161341_tWYc_2359467.jpg\" target=\"_blank\"><img title=\"\" src=\"http://static.oschina.net/uploads/space/2015/0720/161341_tWYc_2359467.jpg\" height=\"301\" width=\"400\" style=\"cursor: pointer;\"></a></p><p><span style=\"font-size: 14px;\"><strong>���ֹ�λ̫�����ˣ���������ңԶ�ľ��룬���������������ԣ��м�ȴ�и�����</strong></span></p><p><span style=\"font-size: 14px;\"><strong>˵���˶����ᣬСС�໹�ǽ����Ǽ���ʵ�õİ��ü����ɣ�������Ҫ��</strong></span></p><p><span style=\"font-size: 14px;\">�Ұ���һŮ�������ǲ��ұ��ס��ò������и�����һ���������պ��Ҿ��������Աߣ����������ų������������������ᲦŪ���ķ��ң��������ҹ����������϶�����С���ظ������ֳ�������衣��Ҳ���������ҵ�������ת��ͷ����ϲ�����ң���ԭ����Ҳ�ŷ�ϲ���������<br></span></p><p><a href=\"http://my.oschina.net/lqzat2011\" target=\"_blank\" rel=\"nofollow\">@����</a><span style=\"font-size: 14px;\">���������ص�Ц��</span></p><p><a href=\"http://static.oschina.net/uploads/space/2015/0720/170105_cBs4_2359467.jpg\" target=\"_blank\"><img title=\"\" src=\"http://static.oschina.net/uploads/space/2015/0720/170105_cBs4_2359467.jpg\" height=\"360\" width=\"400\" style=\"cursor: pointer;\"></a></p><p><span style=\"font-size: 14px;\"><strong>һ�� hello world ����һ���ˣ�����Ц�����������������־��Ƭ����ֱ������ѡ�ж��й�ʲô�ģ�</strong></span></p><p><span style=\"font-size: 14px;\"><strong>���ԣ��ؼ�����Ҫ�¸ҵ�������һ�����������������<br></strong></span></p><p><span style=\"font-size: 14px;\">&nbsp;</span><a href=\"http://my.oschina.net/17zouguo\" target=\"_blank\" rel=\"nofollow\">����˹�</a><span style=\"font-size: 14px;\">�������ϰ�·�Ͽ���һ��Ư����С�����β�������ò�Ʒ������ڸ���������С����������\n" +
	            "�����룬����Ե����������գ����ܻ��������ģ��ұ�׷����ȥ��˵������Ů�����԰���ĵ绰�����𣿡�\n" +
	            "��������˫�֣������ֻ����������ϣ��Ͳֻ������ˡ���&nbsp; <br></span></p><p><span style=\"font-size: 14px;\"><strong>�������Ƕ�ı</strong><br></span></p><p><a href=\"http://my.oschina.net/disney\" target=\"_blank\" rel=\"nofollow\">Tuco-����</a><span style=\"font-size: 14px;\">������Сѧ��ʱ��֪������Ҫ����Ů��Ů�������ܽ�������һ�����ظС��ܺ����ĵ���ʹ�����뿴����Ů������ʲô��ͬ�����ǾͶ�ͬ����Ů��˵�����ҵ�������\n" +
	            "��һ���˿��԰�����ʮ��Ů�������в�������Ů�����ţ�˵������������Ů��������ࡣ����˵�����¿����Ǳ�һ�ȡ������Ⱦͱȡ����¿κ�����Ȼ����9��Ů\n" +
	            "����һ���ӾͰ���������Ů����.......��ʱ��ʵ�����������Ҫһ���ֶΡ�����&nbsp; <br></span></p><p><span style=\"font-size: 14px;\"><strong>���������ֺ�</strong><br></span></p><p><a href=\"http://my.oschina.net/ztd\" target=\"_blank\" rel=\"nofollow\">@��Ʒ����</a><span style=\"font-size: 14px;\">��Լ��</span></p><p><a href=\"http://static.oschina.net/uploads/space/2015/0720/132303_Jdwy_149266.jpg\" target=\"_blank\"><img title=\"\" alt=\"http://static.oschina.net/uploads/space/2015/0720/132303_Jdwy_149266.jpg\" src=\"http://static.oschina.net/uploads/space/2015/0720/132303_Jdwy_149266.jpg\" height=\"580\" width=\"1028\" style=\"cursor: pointer;\"></a></p><p><span style=\"font-size: 14px;\"><strong>Լ���ǲ�Լ�����ڲ���˵�������ϵĲ�Ʊ�������ٴ����</strong></span></p><p><span style=\"font-size: 14px;\"><strong>����������в��õ���ͷ�����������л�ʽ�����<br></strong></span></p><p><a href=\"http://my.oschina.net/mishengqiang\" target=\"_blank\" rel=\"nofollow\">@С�ǲ�˹</a><span style=\"font-size: 14px;\">������Ů�ѳԵ�̫�������Լ��ſ��ˣ���ʱ�ұ���Ц��ο����</span></p><p><a href=\"http://my.oschina.net/wintelsui\" target=\"_blank\" rel=\"nofollow\">@���Ų�С��1_1</a><span style=\"font-size: 14px;\">������Ů��������һ��̷��ǿ��C����,�����е�������</span></p><p><span style=\"font-size: 14px;\"><strong><strong>�ǿ�Ů������̷��ǿ��C���ԣ�����ȴֻ�����ۣ��㻹�ǳ���Գ��</strong></strong></span></p><p><a href=\"http://static.oschina.net/uploads/space/2015/0720/182147_GIi5_2359467.jpg\" target=\"_blank\"><img src=\"http://static.oschina.net/uploads/space/2015/0720/182147_GIi5_2359467.jpg\" style=\"cursor: pointer;\"></a></p><p><a href=\"http://my.oschina.net/hks\" target=\"_blank\" rel=\"nofollow\">@��ļ���</a><span style=\"font-size: 14px;\">������򿪵��ԣ�����ȫ�����ֱ�ץ����Ϣ������������Щ��ҡײƭ��Ĳ���ʲô���뵱��������ͱ���ʫ�����꼴�����abc������ѧ��Сѧ��ʮ����������\n" +
	            "�����������кڿͣ���ѧ������������������Щԭ�򣬲ųɾ����ҽ���ĻԻ͡���˵�ˣ�bug��������Ϣ�ᣬһ����������������·�ϡ�����&nbsp;\t <br></span></p><p><a href=\"http://my.oschina.net/EvaKing\" target=\"_blank\" rel=\"nofollow\">@EvaKing</a><span style=\"font-size: 14px;\">���������յ��磬��ũ�����࣡���������£�Ҳ���������Ҫ���������Ͻ��һ��ᣡ������һλHRд���ҵ��İ�������˵��HRΪ����Ƹ�˲�Ҳ����ƴ���ˡ���ӭ���ʹ�ÿ�Դ�������в�Ʒ�����Ƕ���</span></p><p><a href=\"http://my.oschina.net/u/1770535\" target=\"_blank\" rel=\"nofollow\">@slimina</a><span style=\"font-size: 14px;\">�������յ��磬���Ӳſ��ף���Ϊ�Ӱ�ʣ����ŲŲ��䡣</span></p><p><span style=\"font-size: 14px;\"><strong>��ǰ����λ����Գ�����ϰ࣬Ȼ�󣬾���������Ĺ���</strong><br></span></p><p><a href=\"http://my.oschina.net/maimu\" target=\"_blank\" rel=\"nofollow\">�@�</a><span style=\"font-size: 14px;\">���������岻�ʣ�����ڼ���Ϣ��������˵������˭���ң���˵�Ҳ��ڣ�����Ҿ�˯�ˡ�ͻȻ�绰���ˣ����Ž��˵绰˵�����Ϲ��ڼҡ��ҵ�ʱ�ͷ��𣬲���˵˭���Ҷ�˵�Ҳ���������˵���ֲ�������ġ���������Ťͷ���ĵ�˯�ˡ���&nbsp;\t <br></span></p><p><a href=\"http://my.oschina.net/u/1995201\" target=\"_blank\" rel=\"nofollow\">������ܳ�����������</a><span style=\"font-size: 14px;\">�������������ռǣ�</span></p><p><a href=\"http://static.oschina.net/uploads/space/2015/0720/155916_pZhN_1995201.jpg\" target=\"_blank\"><img title=\"\" alt=\"http://static.oschina.net/uploads/space/2015/0720/155916_pZhN_1995201.jpg\" src=\"http://static.oschina.net/uploads/space/2015/0720/155916_pZhN_1995201.jpg\" height=\"346\" width=\"280\" style=\"cursor: pointer;\"></a></p><p><span style=\"font-size: 14px;\"><strong>������̫�����ˣ�СС�೫�飬ÿһ��������Ӧ��װ��һ�����</strong><br></span></p><p><a href=\"http://my.oschina.net/maimu\" target=\"_blank\" rel=\"nofollow\">�@�</a><span style=\"font-size: 14px;\">����һֱ��˫���εĳ��</span></p><p><a href=\"http://static.oschina.net/uploads/space/2015/0720/163356_8m7O_2359467.jpg\" target=\"_blank\"><img src=\"http://static.oschina.net/uploads/space/2015/0720/163356_8m7O_2359467.jpg\" style=\"cursor: pointer;\"></a></p><p><span style=\"font-size: 14px;\"><strong>�ҵ�����󣬳����⿼�����</strong></span></p><p><a href=\"http://static.oschina.net/uploads/space/2015/0720/210124_2eSl_1428332.jpg\" target=\"_blank\"><img src=\"http://static.oschina.net/uploads/space/2015/0720/210124_2eSl_1428332.jpg\" width=\"300\" height=\"291\" title=\"\" style=\"cursor: pointer;\"></a></p><p><span style=\"display: none; line-height: 0px;\">\u200D</span><span style=\"font-size: 14px;\"><strong><strong><strong><strong>���׶���</strong>��</strong></strong></strong><strong><strong><span style=\"font-size: 16px;\"></span></strong><span style=\"display: none; line-height: 0px;\">\u200D</span>СС����������Ѳ��㣬���λ����ͽ̣�</strong><br></span></p><p><span style=\"font-size: 14px;\"><strong><br></strong></span></p><p><span style=\"font-size: 14px;\"></span></p><p style=\"padding: 0px; margin-top: 8px; margin-bottom: 8px; line-height: 22.5px; letter-spacing: 0.5px; color: rgb(51, 51, 51); white-space: normal; font-family: Verdana, sans-serif, ����; background-color: rgb(255, 255, 255);\"><span style=\"padding: 0px; margin: 0px; font-size: 14px;\"><strong>����������������<br></strong></span></p><p style=\"padding: 0px; margin-top: 8px; margin-bottom: 8px; line-height: 22.5px; letter-spacing: 0.5px; color: rgb(51, 51, 51); white-space: normal; font-family: Verdana, sans-serif, ����; background-color: rgb(255, 255, 255);\"><span style=\"padding: 0px; margin: 0px; font-size: 14px;\"><strong>����ɨһɨ����Ķ�ά�룬��ע����Դ�й��� ΢�źţ�</strong></span></p><p><span style=\"padding: 0px; margin: 0px; font-size: 14px;\"><strong><a href=\"http://static.oschina.net/uploads/space/2013/0304/160442_8Fw6_179699.png\" target=\"_blank\" rel=\"nofollow\"><a href=\"http://static.oschina.net/uploads/space/2013/0304/160442_8Fw6_179699.png\" target=\"_blank\"><img src=\"http://static.oschina.net/uploads/space/2013/0304/160442_8Fw6_179699.png\" title=\"OSC΢�Ŷ�ά��\" style=\"cursor: pointer;\"></a></a></strong></span><br><span style=\"font-size: 14px;\"><span style=\"padding: 0px; margin: 0px;\"><strong>��ɨһɨ����עOSChina΢�źţ�ÿ��Ϊ�����Ͼ�ѡ��Ѷ��㣬����ÿ��� OSChina<strong>&nbsp;�ҵ�</strong>Ŷ��</strong></span></span></p></div>";

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_richtext);

	        richText = (XRichText) findViewById(R.id.richText);

	        richText
	                .callback(new XRichText.BaseClickCallback() {
	                    @Override
	                    public boolean onLinkClick(String url) {
	                        showMsg(url);
	                        return true;
	                    }
	                    @Override
	                    public void onImageClick(List<String> urlList, int position) {
	                        super.onImageClick(urlList, position);
	                        showMsg("ͼƬ:" + position);
	                    }
	                    @Override
	                    public void onFix(XRichText.ImageHolder holder) {
	                        super.onFix(holder);
	                        if (holder.getPosition() % 3 == 0) {
	                            holder.setStyle(XRichText.Style.LEFT);
	                        } else if (holder.getPosition() % 3 == 1) {
	                            holder.setStyle(XRichText.Style.CENTER);
	                        } else {
	                            holder.setStyle(XRichText.Style.RIGHT);
	                        }

	                        //���ÿ���
	                        holder.setWidth(550);
	                        holder.setHeight(400);
	                    }
	                })
	                .imageDownloader(new ImageLoader() {        //��������ã���Ĭ�ϵ�������
	                    @Override
	                    public Bitmap getBitmap(String url) throws IOException {
							return null;
	                       // return UILKit.getLoader().loadImageSync(url);
	                    }
	                })
	                .text(TEXT);
	    }

	    private void showMsg(String msg) {
	        Toast.makeText(XRichTextActivity.this, msg, Toast.LENGTH_SHORT).show();
	    }
	}