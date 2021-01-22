using System;

namespace Steps
{
    class Program
    {
        static void Main(string[] args)
        {
            int target = 10000;
            string steps = Console.ReadLine();
            int counter = 0;
            string output = string.Empty;

            while (steps != "Going home")
            {
                counter += Convert.ToInt32(steps);
                    if (counter >= target)
                    {
                    output = $"Goal reached! Good job!\n{counter - target} steps over the goal!";
                    break;
                    }

                steps = Console.ReadLine();
            }

            if (steps == "Going home")
            {
                int stepsToHome = int.Parse(Console.ReadLine());
                counter += stepsToHome;
                    if (counter >= target)
                    {
                    output = $"Goal reached! Good job!\n{counter - target} steps over the goal!";
                    }
                    else
                    {
                    output = $"{target - counter} more steps to reach goal.";
                    }
            }

            Console.WriteLine(output);

        }
    }
}
