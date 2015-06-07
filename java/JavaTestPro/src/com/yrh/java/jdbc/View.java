package com.yrh.java.jdbc;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * View 层
 * 
 * @author Yrh
 *
 */
public class View {

	// 提示语
	public static final String HINT = "----主菜单----" + "\n[MAIN/M]返回主菜单"
			+ "\n[QUERY/Q]查看所有信息" + "\n[GET/G]查看某 ID 的详细信息" + "\n[ADD/D]添加信息"
			+ "\n[UPDATE/U]更新信息" + "\n[DELETE/D]删除信息" + "\n[SEARCH/S]查询信息"
			+ "\n[EXIT/E]退出程序";

	// 状态常量
	public static final String SELECT_MAIN = "MAIN";
	public static final String SELECT_QUERY = "QUERY";
	public static final String SELECT_GET = "GET";
	public static final String SELECT_ADD = "ADD";
	public static final String SELECT_UPDATE = "UPDATE";
	public static final String SELECT_DELETE = "DELETE";
	public static final String SELECT_SEARCH = "SEARCH";
	public static final String SELECT_EXIT = "EXIT";

	public void start() throws Exception {

		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
		System.out.println(HINT);

		Goddess g = null;
		GoddessAction action = new GoddessAction();

		System.out.print("请输入一个命令：");
		String input = scan.next();

		while (true) {
			if (input.toUpperCase().equals(SELECT_EXIT)
					|| input.toUpperCase().equals(SELECT_EXIT.substring(0, 1))) {
				// 如果达成退出条件，则退出

				System.out.println("系统正在退出，感谢您的使用，请稍候...");
				System.out.println("退出成功！");

				break;
			} else if (input.toUpperCase().equals(SELECT_ADD)
					|| input.toUpperCase().equals(SELECT_ADD.substring(0, 1))) {
				// 添加信息
				g = new Goddess();

				System.out.println("请输入[姓名](不确定的信息输入null，下同)：");
				String name = scan.next();
				if (!name.equals("null")) {
					g.setName(name);
				}

				System.out.println("请输入[性别(1/0)]：");
				String sex = scan.next();
				if (!sex.equals("null")) {
					g.setSex(Integer.parseInt(sex));
				}

				System.out.println("请输入[年龄]：");
				String age = scan.next();
				if (!age.equals("null")) {
					g.setAge(Integer.parseInt(age));
				}

				System.out.println("请输入[生日(Y M D)]：");
				String year = scan.next();
				if (!year.equals("null")) {
					String month = scan.next();
					String day = scan.next();
					Date birth = new Date(Integer.parseInt(year) - 1900,
							Integer.parseInt(month), Integer.parseInt(day));
					g.setBirthday(birth);
				}

				System.out.println("请输入[邮件地址]：");
				String email = scan.next();
				if (!email.equals("null")) {
					g.setEmail(email);
				}

				System.out.println("请输入[电话号码]：");
				String mobile = scan.next();
				if (!mobile.equals("null")) {
					g.setMobile(mobile);
				}

				g.setCreate_date(new Date());
				g.setCreate_user("admin");
				g.setUpdate_date(new Date());
				g.setUpdate_user("admin");
				g.setIsdel(0);

				try {
					System.out.println("您输入的信息为：");
					System.out.println(g.toString());
				} catch (Exception e) {
					System.out.println("您输入的信息有误，是否重新输入[Y/n]?");
					String check = scan.next();
					if (check.startsWith("Y") || check.startsWith("y")) {
						input = "ADD";
						continue;
					} else {
						input = "";
						continue;
					}
				}
				System.out.println("是否确认[Y/n]?");

				String check = scan.next();

				if (check.startsWith("Y") || check.startsWith("y")) {
					action.add(g);
					System.out.println("添加成功！");
				}

			} else if (input.toUpperCase().equals(SELECT_MAIN)
					|| input.toUpperCase().equals(SELECT_MAIN.substring(0, 1))) {
				input = "";
				continue;
			} else if (input.toUpperCase().equals(SELECT_QUERY)
					|| input.toUpperCase().equals(SELECT_QUERY.substring(0, 1))) {
				List<Goddess> result = action.query();
				for (int i = 0; i < result.size(); i++) {
					g = result.get(i);
					System.out.println("编号：" + g.getId() + "\t姓名："
							+ g.getName());
				}
				System.out.println("[输入任意字符返回主菜单]");
				String check = scan.next();
			} else if (input.toUpperCase().equals(SELECT_GET)
					|| input.toUpperCase().equals(SELECT_GET.substring(0, 1))) {
				System.out.println("请输入要查询的[ID号码]：");
				int query = scan.nextInt();
				g = action.get(query);
				if (g == null) {
					System.out.println("没有找到此 ID 的相关信息");
				} else {
					System.out.println(g.toString());
				}
				System.out.println("[输入任意字符返回主菜单]");
				String check = scan.next();
			} else if (input.toUpperCase().equals(SELECT_UPDATE)
					|| input.toUpperCase().equals(SELECT_UPDATE.substring(0, 1))) {
				// 添加信息
				g = new Goddess();
				
				System.out.println("请输入需要修改信息的 [ID]");
				String id = scan.next();
				if (!id.equals("") && id != null) {
					g.setId(Integer.parseInt(id));
				}
				
				Goddess oldG = action.get(Integer.parseInt(id));
				
				if (oldG == null) {
					System.out.println("ID 输入有误，是否重新输入[Y/n]?");
					String check = scan.next();
					if (check.startsWith("Y") || check.startsWith("y")) {
						input = "UPDATE";
						continue;
					} else {
						input = "";
						continue;
					}
				}

				System.out.println("请输入[姓名](无需更改的信息输入null，下同)：");
				String name = scan.next();
				if (!name.equals("null")) {
					g.setName(name);
				} else {
					g.setName(oldG.getName());
				}

				System.out.println("请输入[性别(1/0)]：");
				String sex = scan.next();
				if (!sex.equals("null")) {
					g.setSex(Integer.parseInt(sex));
				} else {
					g.setSex(oldG.getSex());
				}

				System.out.println("请输入[年龄]：");
				String age = scan.next();
				if (!age.equals("null")) {
					g.setAge(Integer.parseInt(age));
				} else {
					g.setAge(oldG.getAge());
				}

				System.out.println("请输入[生日(Y M D)]：");
				String year = scan.next();
				if (!year.equals("null")) {
					String month = scan.next();
					String day = scan.next();
					Date birth = new Date(Integer.parseInt(year) - 1900,
							Integer.parseInt(month), Integer.parseInt(day));
					g.setBirthday(birth);
				} else {
					g.setBirthday(oldG.getBirthday());
				}

				System.out.println("请输入[邮件地址]：");
				String email = scan.next();
				if (!email.equals("null")) {
					g.setEmail(email);
				} else {
					g.setEmail(oldG.getEmail());
				}

				System.out.println("请输入[电话号码]：");
				String mobile = scan.next();
				if (!mobile.equals("null")) {
					g.setMobile(mobile);
				} else {
					g.setMobile(oldG.getMobile());
				}

				g.setUpdate_date(new Date());
				
				g.setCreate_date(oldG.getCreate_date());
				g.setCreate_user(oldG.getCreate_user());
				g.setUpdate_user("admin");
				g.setIsdel(0);

				try {
					System.out.println("更新后的信息为：");
					System.out.println(g.toString());
				} catch (Exception e) {
					System.out.println("您输入的信息有误，是否重新输入[Y/n]?");
					String check = scan.next();
					if (check.startsWith("Y") || check.startsWith("y")) {
						input = "UPDATE";
						continue;
					} else {
						input = "";
						continue;
					}
				}
				System.out.println("是否确认[Y/n]?");

				String check = scan.next();

				if (check.startsWith("Y") || check.startsWith("y")) {
					action.update(g);
					System.out.println("更新成功！");
					
					System.out.println("[输入任意字符返回主菜单]");
					check = scan.next();
				}
			} else if (input.toUpperCase().equals(SELECT_DELETE)
					|| input.toUpperCase().equals(SELECT_DELETE.substring(0, 1))) {
				System.out.println("请输入要删除的[ID号码]：");
				int query = scan.nextInt();
				g = action.get(query);
				if (g == null) {
					System.out.println("ID 输入有误，是否重新输入[Y/n]?");
					String check = scan.next();
					if (check.startsWith("Y") || check.startsWith("y")) {
						input = "DELETE";
						continue;
					} else {
						input = "";
						continue;
					}
				} else {
					System.out.println("编号：" + g.getId() + "\t姓名：" + g.getName());
					System.out.println("确定要删除吗[Y/n]?");
					String check = scan.next();
					if (check.startsWith("Y") || check.startsWith("y")) {
						action.del(g.getId());
						System.out.println("删除成功！");
						
						System.out.println("[输入任意字符返回主菜单]");
						check = scan.next();
					} else {
						input="";
						continue;
					}
				}
				
				
			}// end if

			// 输出提示语
			for (int i = 0; i < 10; i++) {
				System.out.println();
			}
			System.out.println(HINT);
			System.out.print("请输入一个命令：");
			input = scan.next();
		}
	}

}
