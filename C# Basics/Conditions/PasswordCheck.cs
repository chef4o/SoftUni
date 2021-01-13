using System;

namespace PasswordChack
{
    class Program
    {
        static void Main(string[] args)
        {
            string password = Console.ReadLine();
            string secret = "s3cr3t!P@ssw0rd";

            if (password == secret)
            {
                Console.WriteLine("Welcome");
            }
            else
            {
                Console.WriteLine("Wrong password!");
            }
        }
    }
}
