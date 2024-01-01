#include <stdio.h>
#include <string.h>
int main(void)
{
	char array[1000000];
	char* token;
	char seps[] = " ";

	gets(array);
	int count = 0;
	token = strtok(array, seps);
	while (token != NULL) {
		count++;
		token = strtok(NULL, seps);
	}
	printf("%d", count);
	return 0;
}