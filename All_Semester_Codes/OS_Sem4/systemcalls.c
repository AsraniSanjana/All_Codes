#include <unistd.h>
 #include <stdio.h>
#include <fcntl.h>
#include <errno.h>
#include <stdlib.h>
#include <string.h>
extern int errno;
int main()
{
      int choice, sz, fd, val;
      char *c = (char *)calloc(100, sizeof(char));
      do
      {
                printf("\n**MENU**\n1.Open\t 2.Read\t 3.Write\t 4.Close\t 5.getpid\t 6.setpid\t 7.getuid\t 8.getgid\t 9.getegid\t 10.geteuid\t 11.EXIT\n");
                printf("\nEnter your choice: ");
                scanf("%d", &choice);
                switch (choice)
                {
                 case 1:
                                fd = open("Sanjana.txt", O_RDONLY | O_CREAT);
                                printf("fd=%d with open system call\n", fd);
                                if (fd == -1)
                                {
                                     printf("Error Number % d\n", errno);
                                     perror("Program");
                                 }
                                break;
                 case 2:
                               fd = open("Sanjana.txt", O_RDONLY);
                               if (fd < 0)
                              {
                                  perror("r1");
                                   exit(1);
                              }
                              sz= read(fd, c, 50);
                              printf("called read(% d, c, 50). returned that %d bytes were read.\n", fd, sz);
                              c[sz] = '\0';
                              printf( "Those bytes are as follows: %s\n", c);
                              break;

                 case 3:
                              fd = open("sample1.txt", O_WRONLY | O_CREAT | O_TRUNC, 0644);
                              if (fd < 0)
                              {
                                       perror("r1");
                                       exit(1);
                              }
                              sz= write(fd, "hello friend\n", strlen("hi friend\n"));
                              printf("called write(% d, \"ht friend\\n\",%ld) \\ It returned %d\n", fd, strlen("hi friend\n"), sz);
                              close(fd);
                              break;
                 case 4:
                              fd = open("sample.txt", O_RDONLY);
                              if (fd < 0)
                              {
                                        perror("c1");
                                        exit(1);
                              }
                              printf("opened the fd = % d\n", fd);
                              if (close(fd) < 0)
                              {
                                        perror("c1");
                                        exit(1);
                              }
                              printf("closed the fd. \n");
                              break;
                 case 5:
                              printf("Current process id is %d\n", getpid());
                              break;
                 case 6:     if ((val==fork()))
                              {
                              printf("Problem creating process");
                              }
                              else
                              {
                                        setuid(1010);
                                        printf("Current process id is %d\n", getpid());
                                        printf("user id is %d\n", getuid());
                                        printf("group id is %d\n", getgid());
                                        printf("effective group id is %d\n", getegid());
                                        printf("effective user id is %d\n", geteuid());
                              }
                              break;

               case 7:
                              printf("Current user id is %d\n", getuid());
                              break;
                 case 8:
                              printf("Group id is %d\n", getgid());
                              break;
                 case 9:
                              printf("effective group id is %d\n", getegid());
                              break;
                 case 10:
                              printf("effective user id is %d\n", geteuid());
                              break;
                 default:
                              printf("Invalid choice");
                              break;
                }
      }while (choice != 11);
      return 0;
}
