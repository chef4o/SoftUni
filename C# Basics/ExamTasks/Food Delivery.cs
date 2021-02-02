using System;

namespace ExamPrep
{
    class Program
    {
        static void Main(string[] args)
        {
            int chickenMenu = int.Parse(Console.ReadLine());
            int fishMenu = int.Parse(Console.ReadLine());
            int veggieMenu = int.Parse(Console.ReadLine());

            double chickenPrice = chickenMenu * 10.35;
            double fishPrice = fishMenu * 12.40;
            double veggiePrice = veggieMenu * 8.15;
            double desertPrice = (chickenPrice + fishPrice + veggiePrice) * 20.0 / 100;
            double delivery = 2.5;
            double totalPrice = chickenPrice + fishPrice + veggiePrice + desertPrice + delivery;

            Console.WriteLine($"Total: {totalPrice:f2}");
        }
    }
}
