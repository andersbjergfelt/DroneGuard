using System;
using DroneGuardSystem.Protocols;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Hosting;

namespace DroneGuardSystem
{
    public class Program
    {
        public static void Main(string[] args)
        {
            
            //CreateHostBuilder(args).Build().Run();
            var s = new UdpSocket();
            s.Server("127.0.0.1", 4445);
            while (true)
            {
                Console.ReadKey();
            }
           
        }

        public static IHostBuilder CreateHostBuilder(string[] args) =>
            Host.CreateDefaultBuilder(args)
                .ConfigureWebHostDefaults(webBuilder => { webBuilder.UseStartup<Startup>(); });
    }
}