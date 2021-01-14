using System;

namespace FruitOrVeggi
{
    class Program
    {
        static void Main(string[] args)
        {
            string fruit = Console.ReadLine();

            string result = string.Empty;

            switch (fruit)
            {
                case "banana":
                case "apple":
                case "kiwi":
                case "cherry":
                case "lemon":
                case "grapes":
                    result = "fruit";
                    break;
                case "tomato":
                case "cucumber":
                case "pepper":
                case "carrot":
                    result = "vegetable";
                    break;
                default:
                    result = "unknown";
                    break;             
            }

            Console.WriteLine(result);

        }
    }
}
