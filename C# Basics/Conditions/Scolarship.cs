using System;
using System.Collections.Specialized;
using System.Net.Sockets;

namespace Scolarship
{
    class Program
    {
        static void Main(string[] args)
        {
            double income = double.Parse(Console.ReadLine());
            double grade = double.Parse(Console.ReadLine());
            double minWage = double.Parse(Console.ReadLine());

            double socialScholarship = Math.Floor(minWage * (35.0 / 100));
            double gradeScolarship = Math.Floor(grade * 25);

            string highGrade = $"You get a scholarship for excellent results {gradeScolarship} BGN";
            string social = $"You get a Social scholarship {socialScholarship} BGN";

            if (income <= minWage && grade >= 5.50 && gradeScolarship >= socialScholarship)
            {
                Console.WriteLine(highGrade);
            }
            else if (income <= minWage && grade >= 5.5 && gradeScolarship < socialScholarship)
            {
                Console.WriteLine(social);
            }
            else if (income > minWage && grade >= 5.5)
            {
                Console.WriteLine(highGrade);
            }
            else if (income <= minWage && grade > 4.5)
            {
                Console.WriteLine(social);
            }
            else
            {
                Console.WriteLine("You cannot get a scholarship!");
            }

        }
    }
}
