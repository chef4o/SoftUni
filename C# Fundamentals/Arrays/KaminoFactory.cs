using System;
using System.Linq;

namespace KaminoFactory
{
    class Program
    {
        static void Main(string[] args)
        {
            int sequenceLenght = int.Parse(Console.ReadLine());
            string input = Console.ReadLine();

            int[] bestSample = new int[sequenceLenght];
            int bestSequence = 0;
            int bestSequenceIndex = 0;
            int bestOnesCount = 0;


            int sampleCounter = 0;
            int bestDnaString = 0;

            while (input != "Clone them!")
            {
                int[] dnaCode = input.Split("!")
                                     .Select(int.Parse)
                                     .ToArray();
                sampleCounter++;

                int onesCount = 0;
                int onesSequence = 0;
                int biggestSequence = 0;
                int biggestSequenceIndex = 0;

                for (int i = 0; i < dnaCode.Length - 1; i++)
                {

                    if (dnaCode[i] == 1)
                    {
                        onesCount++;
                        onesSequence++;
                    }
                    else
                    {
                        biggestSequence = onesSequence;
                        biggestSequenceIndex = (i + 1) - onesSequence;
                        onesSequence = 0;
                    }
                    if (i == dnaCode.Length - 2 && 
                        dnaCode[dnaCode.Length - 1] == 1)
                    {
                        onesCount++;
                    }
                }

                if (biggestSequence > bestSequence)
                {
                    bestSequence = biggestSequence;
                    bestSample = dnaCode;
                    bestDnaString = sampleCounter;
                }
                else if (biggestSequence == bestSequence && 
                         biggestSequenceIndex < bestSequenceIndex)
                {
                    bestSequenceIndex = biggestSequenceIndex;
                    bestSample = dnaCode;
                    bestDnaString = sampleCounter;

                }
                else if (biggestSequence == bestSequence && 
                         biggestSequenceIndex == bestSequenceIndex && 
                         onesCount > bestOnesCount)
                {
                    bestSample = dnaCode;
                    bestDnaString = sampleCounter;
                }

                input = Console.ReadLine();
            }

            Console.WriteLine($"Best DNA sample {bestDnaString} with sum: {bestOnesCount}.\n{string.Join(" ", bestSample)}");
        }
    }
}
