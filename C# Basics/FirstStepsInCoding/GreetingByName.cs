    using System;

    namespace GreetingByName
    {
        class Program
        {
            static void Main(string[] args)
            {
            string firstName = Console.ReadLine();
            string lasstName = Console.ReadLine();
            int age = int.Parse(Console.ReadLine());
            string town = Console.ReadLine();
            Console.WriteLine($"You are {firstName} {lasstName}, a {age}-years old person from {town}.);
            }
        }
    }
