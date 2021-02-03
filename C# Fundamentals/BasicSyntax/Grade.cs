using System;

namespace Grade
{
    class Program
    {
        static void Main(string[] args)
        {
            double grade = double.Parse(Console.ReadLine());

            string output = string.Empty;
            if (grade >= 3)
            {
                output = "Passed!";
            }
            else
            {
                output = "Failed!";
            }

            Console.WriteLine(output);
        }
    }
}
