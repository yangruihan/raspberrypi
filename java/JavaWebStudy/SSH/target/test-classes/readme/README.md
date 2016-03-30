部署说明：
1. JDK环境：1.8
2. Tomcat环境：7.**
3. maven环境：3.3.3
4. MyEclipse工作空间项目编码设置为UTF-8
5. 强力去污：【maven clean】+【Project clean】
6. 数据库用户名和密码记得更换成自己的
7. Tomcat导入MyEclipse时将JDK设置为1.8
8. JDK版本问题请留意pom.xml中的配置【可以根据情况适当修改】：
	<profiles>
		<profile>
			<id>jdk-1.8</id>
			<activation>
				<activeByDefault>true</activeByDefault>
				<jdk>1.8</jdk>
			</activation>
			<properties>
				<maven.compiler.source>1.8</maven.compiler.source>
				<maven.compiler.target>1.8</maven.compiler.target>
				<maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
			</properties>
		</profile>
	</profiles>