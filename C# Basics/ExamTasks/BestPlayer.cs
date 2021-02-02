using System;
using System.Xml;

namespace Task5
{
    class Program
    {
        static void Main(string[] args)
        {
            string bestPlayer = string.Empty;
            bool madeHatTrick = false;
            int topScore = 0;
            string output = string.Empty;

            string input = Console.ReadLine();
            while (input != "END")
            {
                int goals = int.Parse(Console.ReadLine());
                if (goals >= 3)
                {
                    madeHatTrick = true;
                }
                else
                {
                    madeHatTrick = false;
                }

                if (goals > topScore)
                {
                    bestPlayer = input;
                    topScore = goals;
                }

                if (goals >= 10)
                {
                    break;
                }

                input = Console.ReadLine();
            }

            if (madeHatTrick)
            {
                output = $"{bestPlayer} is the best player!\nHe has scored {topScore} goals and made a hat-trick !!!";
            }
            else
            {
                output = $"{bestPlayer} is the best player!\nHe has scored {topScore} goals.";
            }

            Console.WriteLine(output);

        }
    }
}
