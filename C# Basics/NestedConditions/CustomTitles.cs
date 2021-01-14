using System;

namespace CustomTitles
{
    class Program
    {
        static void Main(string[] args)
        {
            double age = double.Parse(Console.ReadLine());
            string gender = Console.ReadLine();

            string title = string.Empty;

            if (gender == "m" && age >= 16)
            {
                title = "Mr.";
            }
            else if (gender == "m" && age <16)
            {
                title = "Master";
            }
            else if (gender == "f" && age >= 16)
            {
                title = "Ms.";
            }
            else if (gender == "f" && age < 16)
            {
                title = "Miss";
            }

            Console.WriteLine(title);
        }
    }
}
