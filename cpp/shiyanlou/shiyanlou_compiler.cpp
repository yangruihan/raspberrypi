if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) //读到第一个字母
{
	pos = 0;
	tword[pos++] = ch;
	while (readin.get(ch)) //继续读，直到该单词结束
	{
		if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))
		{
			if (pos < 49) tword[pos++] = ch;
			if (readin.eof()) eof = true;
		}
		else break;
	}
	tword[pos] = 0;
	word = string(tword);
	kcn = keyjudge(word); //keyjudge()函数判断单词符号的类型
	output << kcn << " " << word << endl;
	if (eof == true) break;
	ready = false;
}
else if (ch == '\"')
{
	pos = 0;
	kcn = KEY_NUM + 24;
	output << kcn << " " << ch << endl;
	
	while (readin.get(ch)) //读取双引号括起来的内容
	{
		if (ch != '\'' && ch != '\"') //如果没有遇到下一个引号，继续读取
		{
			if (pos < 49) tword[pos++] = ch;
		}
		else break;
	}
	tword[pos] = 0;
	word = string(tword);
	kcn = KEY_NUM + 1; //将双引号括起来的部分识别为字符串
	output << kcn << " " << word << endl; //输出该字符串

	if (ch == '\"')
	{
		kcn = KEY_NUM + 24;
		output << kcn << " " << ch << endl;
	}
	else
	{
		kcn = -1;
		output << kcn << " " << ch << endl;
	}
}





























