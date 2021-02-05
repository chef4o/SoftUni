using System;

namespace Login
{
    class Program
    {
        static void Main(string[] args)
        {
            string userName = Console.ReadLine();

            string correctPassword = string.Empty;
            for (int i = userName.Length - 1; i >= 0; i--)
            {
                correctPassword += userName[i];
            }

            int counter = 0;
            while (true)
            {
                string currentPassword = Console.ReadLine();
                counter++;

                if (counter == 4)
                {
                    Console.WriteLine($"User {userName} blocked!");
                    break;
                }
                
                if (currentPassword != correctPassword)
                {
                    Console.WriteLine("Incorrect password. Try again.");
                }
                else
                {
                    Console.WriteLine($"User {userName} logged in.");
                    break;
                }
            }
        }
    }
}
