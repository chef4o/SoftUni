using System;
using System.Globalization;
using System.Xml;

namespace ReportSystem
{
    class Program
    {
        static void Main(string[] args)
        {
            int campaignTarget = int.Parse(Console.ReadLine());

            int paymentType = 0; // cash = even ; card = odd
            double totalCash = 0;
            int cashTrns = 0;
            double totalCard = 0;
            int cardTrns = 0;

            string output = string.Empty;

            string transaction = Console.ReadLine();
            while (transaction != "End")
            {
                string trnOutput = string.Empty;

                if (paymentType % 2 == 0 && Convert.ToInt32(transaction) <= 100)
                {
                    trnOutput = "Product sold!";
                    totalCash += Convert.ToInt32(transaction);
                    cashTrns++;
                }
                else if (paymentType % 2 != 0 && Convert.ToInt32(transaction) >= 10)
                {
                    trnOutput = "Product sold!";
                    totalCard += Convert.ToInt32(transaction);
                    cardTrns++;
                }
                else
                {
                   trnOutput = "Error in transaction!";
                }

                Console.WriteLine(trnOutput);
                paymentType++;

                if (totalCard + totalCash >= campaignTarget)
                {
                    output = $"Average CS: {totalCash * 1.0 / cashTrns:f2}\n" +
                             $"Average CC: {totalCard * 1.0 / cardTrns:f2}";
                    break;
                }

                transaction = Console.ReadLine();
            }

            if (transaction == "End")
            {
                output = $"Failed to collect required money for charity.";
            }

            Console.WriteLine(output);

        }
    }
}