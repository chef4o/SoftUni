using System;

namespace VegieMarket
{
    class Program
    {
        static void Main(string[] args)
        {
            double vegiePrice = double.Parse(Console.ReadLine());
            double fruitPrice = double.Parse(Console.ReadLine());
            double vegieWeight = double.Parse(Console.ReadLine());
            double fruitWeight = double.Parse(Console.ReadLine());

            double totalPrice = (vegiePrice * vegieWeight) + (fruitPrice * fruitWeight);
            double eurPrice = totalPrice / 1.94;

            Console.WriteLine($"{eurPrice:f2}");
            
        }
    }
}
