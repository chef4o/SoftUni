using System;

namespace TwoNumbersSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int startNum = int.Parse(Console.ReadLine());
            int endNum = int.Parse(Console.ReadLine());
            int magicNum = int.Parse(Console.ReadLine());

            int counter = 0;
            int success = 0;
            bool magicNumFound = false;
            string output = string.Empty;

            for (int i = startNum; i <= endNum; i++)
            {
                for (int j = startNum; j <= endNum; j++)
                {
                    counter++;

                    if (i + j == magicNum)
                    {
                        success = counter;
                        magicNumFound = true;
                        output = $"Combination N:{success} ({i} + {j} = {magicNum})";
                        break;
                    }
                }

                if (magicNumFound)
                {
                    break;
                }
            }

            if (!magicNumFound)
            {
                output = $"{counter} combinations - neither equals {magicNum}";
            }

            Console.WriteLine(output);

        }
    }
}
