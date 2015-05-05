main (){
	int a[5];
	int b = 0;
	int c = 0;
	write "please input five numbers:";
	write endl;
	while (c<5){
		read a[c];
		b = b + a[c];
		c=c+1;
	}
	write "the sum of the numbers is:";
	write endl;
	write b;
	write endl;
}
