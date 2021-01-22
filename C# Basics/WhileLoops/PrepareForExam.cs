using System;
using System.Runtime.CompilerServices;
using System.Threading.Tasks;

namespace PrepareForExam
{
    class Program
    {
        static void Main(string[] args)
        {
            int maxBadScore = int.Parse(Console.ReadLine());

            double totalScore = 0;
            int tasksSolved = 0;
            int failureCount = 0;
            string lastTask = string.Empty;
            string output = string.Empty;

            while (true)
            {
                string taskName = Console.ReadLine();
                   if (taskName == "Enough")
                   {
                        output = $"Average score: {totalScore / tasksSolved:f2}\nNumber of problems: {tasksSolved}\nLast problem: {lastTask}";
                        break;
                   }
                int taskScore = int.Parse(Console.ReadLine());

                if (taskScore > 4)
                {
                    totalScore += taskScore;
                    lastTask = taskName;
                    tasksSolved++;
                }
                else
                {

                    totalScore += taskScore;
                    tasksSolved++;
                    failureCount++;
                    if (failureCount == maxBadScore)
                    {
                        output = $"You need a break, {failureCount} poor grades.";
                        break;
                    }
                }
            }

            Console.WriteLine(output);

        }
    }
}
