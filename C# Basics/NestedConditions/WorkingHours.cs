using System;
using System.Dynamic;

namespace WorkingHours
{
    class Program
    {
        static void Main(string[] args)
        {
            int hour = int.Parse(Console.ReadLine());
            string day = Console.ReadLine();

            string status = string.Empty;

            switch (day)
            {
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                case "Saturday":

                    if (hour >= 10 && hour <=18)
                    {
                        status = "open";
                    }
                    else
                    {
                        status = "closed";
                    }
                    break;

                case "Sunday":

                    status = "closed";
                    break;   
            }

            Console.WriteLine(status);

        }
    }
}
