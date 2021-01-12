using System;

namespace CharityCampaign
{
    class Program
    {
        static void Main(string[] args)
        {
            int campaignDays = int.Parse(Console.ReadLine());
            int workers = int.Parse(Console.ReadLine());
            int cakes = int.Parse(Console.ReadLine());
            int waffles = int.Parse(Console.ReadLine());
            int pancakes = int.Parse(Console.ReadLine());

            double cakesPrice = cakes * 45;
            double wafflelPrice = waffles * 5.80;
            double pancakesPrice = pancakes * 3.20;

            double netProfit = (cakesPrice + wafflelPrice+ pancakesPrice) * workers * campaignDays;
            double endProfit = netProfit - (netProfit / 8);

            Console.WriteLine(endProfit);
        }
    }
}
