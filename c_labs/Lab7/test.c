#include<stdio.h>
#include<stdlib.h>
struct Student
{
	char Name[20];
	int  Grades[5];
};
struct Student FillStudent()
{
	struct Student std;
	int i;
	printf("Enter Student Name: ");
	scanf("%s", std.Name);
	printf("Enter Student Grades:\n");
	for (i = 0; i < 5; i++)
	{
		printf("Enter Grade of Subject %d:", i + 1);
		scanf("%d", &std.Grades[i]);
	}
	return std;
}
void PrintStudent(struct Student std)
{
	int i;
	printf("Student Name: %s", std.Name);
	for (i = 0; i < 5; i++)
	{
		printf("\t Grade of Subject %d : %d\n", i + 1, std.Grades[i]);
	}
}

void main()
{
	struct Student **Std;
	int NumClasses;
	int NumStudperClass;
	int cls, stdcls;
	printf("Enter Number of classes in the school");
	scanf("%d", &NumClasses);
	Std = (struct Student **)malloc(NumClasses * sizeof(struct Student *));
	if (Std)
	{
		for (cls = 0; cls < NumClasses; cls++)
		{
		      printf("Enter Number of Student in class %d: ", cls + 1);
		      scanf("%d", &NumStudperClass);
		      Std[cls] = (struct Student*)malloc(NumStudperClass * sizeof(struct Student));
		}
	}for(cls = 0 ; cls < NumClasses ; cls++)
{
	for(stdcls = 0 ; stdcls < NumStudperClass ; stdcls++)
	{
		*(*(Std + cls) + stdcls) = FillEmployee();
	}
}
}
