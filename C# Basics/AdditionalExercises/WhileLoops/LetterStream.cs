using System;
using System.Globalization;

namespace LetterStream
{
    class Program
    {
        static void Main(string[] args)
        {

            bool cFlag = false;
            bool oFlag = false;
            bool nFlag = false;
            string words = string.Empty;
            string output = string.Empty;

            string input = Console.ReadLine();
            
            while (input != "End")
            {
                char letter = char.Parse(input);

                int i = Convert.ToInt32(letter);
                if ((i >= 65 && i <= 90) || (i >= 97 && i < 122))
                {
                    if (letter != 'c' && letter != 'o' && letter != 'n')
                    {
                        output += $"{Convert.ToChar(i)}";
                    }
                    else if (letter == 'c' && cFlag)
                    {
                        output += $"{Convert.ToChar(i)}";
                    }
                    else if (letter == 'o' && oFlag)
                    {
                        output += $"{Convert.ToChar(i)}";
                    }
                    else if (letter == 'n' && nFlag)
                    {
                        output += $"{Convert.ToChar(i)}";
                    }

                    if (letter == 'c')
                    {
                        cFlag = true;
                    }
                    if (letter == 'o')
                    {
                        oFlag = true;
                    }
                    if (letter == 'n')
                    {
                        nFlag = true;
                    }

                    if (cFlag == true && oFlag == true && nFlag == true)
                    {
                        words += output;
                        output = " ";
                        cFlag = false;
                        oFlag = false;
                        nFlag = false;
                    }

                    input = Console.ReadLine();

                }

                else
                {
                    input = Console.ReadLine();
                }
            }

            if (input == "End")
            {
                Console.WriteLine(words);
            }
        }
    }
}
