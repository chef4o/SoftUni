using Microsoft.VisualBasic;
using System;
using System.Security.Cryptography;
using System.Xml;
using System.Xml.Serialization;

namespace OnTimeForExam
{
    class Program
    {
        static void Main(string[] args)
        {

            int ExamHour = int.Parse(Console.ReadLine());
            int ExamMin = int.Parse(Console.ReadLine());
            int ArrivalHour = int.Parse(Console.ReadLine());
            int ArrivalMin = int.Parse(Console.ReadLine());

            int examTime = ExamHour * 60 + ExamMin;
            int arrivalTime = ArrivalHour * 60 + ArrivalMin;
            int difference = Math.Abs(examTime - arrivalTime);

            string output = string.Empty;

            if (examTime == arrivalTime)
            {
                output = "On time";
            }
            else if (examTime > arrivalTime)
            {
                if (difference <= 30)
                {
                    output = $"On time\n{difference} minutes before the start";
                }
                else if (difference > 30 && difference < 60)
                {
                    output = $"Early\n{difference} minutes before the start";
                }
                else if (difference >= 60)
                {
                    if (difference % 60 < 10)
                    {
                        output = $"Early\n{Math.Floor(difference / 60.0)}:0{difference % 60} hours before the start";
                    }
                    else
                    {
                        output = $"Early\n{Math.Floor(difference / 60.0)}:{difference % 60} hours before the start";
                    }
                }
            }
            else if (arrivalTime > examTime)
            {
                if (difference < 60)
                {
                    output = $"Late\n{difference} minutes after the start";
                }
                else if (difference >= 60)
                {
                    if (difference % 60 < 10)
                    {
                        output = $"Late\n{Math.Floor(difference / 60.0)}:0{difference % 60} hours after the start";
                    }
                    else
                    {
                        output = $"Late\n{Math.Floor(difference / 60.0)}:{difference % 60} hours after the start";
                    }
                }
            }

            Console.WriteLine(output);
        }
    }
}
