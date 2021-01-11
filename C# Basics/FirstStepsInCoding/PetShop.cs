using System;

namespace PetShop
{
    class Program
    {
        static void Main(string[] args)
        {
            int dogs = int.Parse(Console.ReadLine());
            int animals = int.Parse(Console.ReadLine());
            double funds = (dogs * 2.50) + (animals * 4.00);
            Console.WriteLine(funds + " lv.");   
        }
    }
}
