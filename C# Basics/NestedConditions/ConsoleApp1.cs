using System;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {

            {
                int number = int.Parse(Console.ReadLine());
                string day = Console.ReadLine();
                {
                    if (number >= 10 && number <= 18)
                    {
                        if (day == "Monday" || day == "Tuesday" || day == "Wednesday"
                        || day == "Thursday"
                        || day == "Friday" || day == "Saturday")
                        {
                            Console.WriteLine("open");
                        }
                        else
                        {
                            Console.WriteLine("closed");
                        }
                    }
                    else
                    {
                        if (day == "Sunday") ;
                        {   
                            Console.WriteLine("closed");
                        }
                    }
                }
            }
        }
    }
}
    }
}
