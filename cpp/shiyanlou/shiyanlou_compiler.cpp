if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) //������һ����ĸ
{
	pos = 0;
	tword[pos++] = ch;
	while (readin.get(ch)) //��������ֱ���õ��ʽ���
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
	kcn = keyjudge(word); //keyjudge()�����жϵ��ʷ��ŵ�����
	output << kcn << " " << word << endl;
	if (eof == true) break;
	ready = false;
}
else if (ch == '\"')
{
	pos = 0;
	kcn = KEY_NUM + 24;
	output << kcn << " " << ch << endl;
	
	while (readin.get(ch)) //��ȡ˫����������������
	{
		if (ch != '\'' && ch != '\"') //���û��������һ�����ţ�������ȡ
		{
			if (pos < 49) tword[pos++] = ch;
		}
		else break;
	}
	tword[pos] = 0;
	word = string(tword);
	kcn = KEY_NUM + 1; //��˫�����������Ĳ���ʶ��Ϊ�ַ���
	output << kcn << " " << word << endl; //������ַ���

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





























