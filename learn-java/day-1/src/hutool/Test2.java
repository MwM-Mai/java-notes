package hutool;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 网络爬虫
public class Test2 {
  public static void main(String[] args) throws IOException, URISyntaxException {

	String familyNameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d";
	String boyNameNet = "http://www.haoming8.cn/baobao/10881.html";
	String girlNameNet = "http://www.haoming8.cn/baobao/7641.html";

	String familyNameStr = webCrawler(familyNameNet);
	String boyNameStr = webCrawler(boyNameNet);
	String girlNameStr = webCrawler(girlNameNet);

	// 通过正则表达式获取到其中符合的数据
	ArrayList<String> familyNameTempList = getData(familyNameStr, "([\\u4e00-\\u9fa5·]{4})(，|。)", 1);
	ArrayList<String> boyNameTempList = getData(boyNameStr, "([\\u4e00-\\u9fa5·]{2})(、|。)", 1);
	ArrayList<String> girlNameTempList = getData(girlNameStr, "(.. ){4}(..)", 0);

	ArrayList<String> familyNameList = new ArrayList<>();
	ArrayList<String> girlNameList = new ArrayList<>();

	familyNameTempList.forEach(item -> {
	  for (int i = 0; i < item.length(); i++) {
		char c = item.charAt(i);
		familyNameList.add(c + "");
	  }
	});

	// HashSet 去重
	Set<String> boyHs = new HashSet<>(boyNameTempList);
	ArrayList<String> boyNameList = new ArrayList<>(boyHs);

	girlNameTempList.stream().map(item -> item.split(" ")).forEach(s -> {
	  for (String string : s) {
		if (!girlNameList.contains(string)) {
		  girlNameList.add(string);
		}
	  }
	});

	ArrayList<String> infos = getInfos(familyNameList, boyNameList, girlNameList, 20, 30);
	//System.out.println(infos);

	BufferedWriter bw = new BufferedWriter(new FileWriter("hutool\\info.txt"));
	for (String info : infos) {
	  bw.write(info);
	  bw.newLine();
	}
	bw.close();
  }

  /**
   * 获取男生和女生的信息(姓名唯一)-性别-年龄
   *
   * @param familyNameList 姓氏集合
   * @param boyNameList    男生名称集合
   * @param girlNameList   女生名称集合
   * @param boyCount       男生个数
   * @param girlCount      女生个数
   * @return ArrayList<String>
   */
  public static ArrayList<String> getInfos(ArrayList<String> familyNameList, ArrayList<String> boyNameList, ArrayList<String> girlNameList, Integer boyCount, Integer girlCount) {
	ArrayList<String> boyList = new ArrayList<>();
	HashSet<String> useName = new HashSet<>();
	while (boyList.size() < boyCount) {
	  Random fnrd = new Random();
	  Random nrd = new Random();
	  Random ard = new Random();
	  int fni = fnrd.nextInt(familyNameList.size());
	  int ni = nrd.nextInt(boyNameList.size());
	  int ai = ard.nextInt(10) + 18;
	  String name = familyNameList.get(fni) + boyNameList.get(ni);
	  //Collections.shuffle(boyNameList); 也可以用 shuffle 打乱数组集合
	  if(!useName.contains(name)) {
		useName.add(name);
		boyList.add(name + "-男-" + ai);
	  }
	}

	ArrayList<String> girlList = new ArrayList<>();
	while (girlList.size() < girlCount) {
	  Random ard = new Random();
	  Collections.shuffle(familyNameList);
	  Collections.shuffle(girlNameList);
	  int ai = ard.nextInt(10) + 18;
	  String name = familyNameList.get(0) + girlNameList.get(0);
	  if(!useName.contains(name)) {
		useName.add(name);
		girlList.add(name + "-女-" + ai);
	  }
	}

	ArrayList<String> infoList = new ArrayList<>();
	infoList.addAll(boyList);
	infoList.addAll(girlList);
	return infoList;
  }

  /**
   * 根据正则表达式获取数据
   *
   * @param str  爬取的完整数据
   * @param regs 正则表达式
   * @return ArrayList<String>
   * @
   */
  private static ArrayList<String> getData(String str, String regs, int index) {
	ArrayList<String> list = new ArrayList<>();
	Pattern pattern = Pattern.compile(regs); // 过去正则表达式对象
	// 按照pattern的规则,到str中获取数据
	Matcher matcher = pattern.matcher(str);
	while (matcher.find()) {
	  String group = matcher.group(index); // group 返回符合要求的数据
	  list.add(group);
	}
	return list;
  }

  /**
   * 作用:
   * 从网络爬取数据, 把数据拼接成字符串返回
   *
   * @param net 网址
   * @return 爬取到的所有数据
   */
  public static String webCrawler(String net) throws IOException, URISyntaxException {
	StringBuilder sb = new StringBuilder();
	URI uri = new URI(net);
	URL url = uri.toURL();
	// 链接上网址
	URLConnection conn = url.openConnection();
	// 读取数据  conn.getInputStream() 为字节流 可能存在中文需要转换成字符流
	InputStreamReader isr = new InputStreamReader(conn.getInputStream());
	int ch;
	while ((ch = isr.read()) != -1) {
	  sb.append((char) ch);
	}
	// 释放资源
	isr.close();

	return sb.toString();
  }

  ;
}
