namespace CalculoMedia
{
    public class Program
    {
        private static void Main()
        {
            List<ResultadoModel> resultados = new();
            List<AlunoModel> alunos = new()
            {
                new AlunoModel()
                {
                    Nome = "aluno6",
                    Notas = new decimal[] { 10, 9, 10 }
                },
                new AlunoModel()
                {
                    Nome = "aluno7",
                    Notas = new decimal[] { 5, 6, 5 }
                },
                new AlunoModel()
                {
                    Nome = "aluno1",
                    Notas = new decimal[] { 3, 4, 10, 4, 10, 10, 10, 1 }
                },
                new AlunoModel()
                {
                    Nome = "aluno3",
                    Notas = new decimal[] { 4, 3, 3 }
                },
                new AlunoModel()
                {
                    Nome = "aluno5",
                    Notas = new decimal[] { 3, 4, 10 }
                },
                new AlunoModel()
                {
                    Nome = "aluno4",
                    Notas = new decimal[] { 3, 4, 10 }
                },
                new AlunoModel()
                {
                    Nome = "aluno2",
                    Notas = new decimal[] { 3, 4, 10 }
                },
            };

            CalcularMediaAlunos(resultados, alunos);
            MostraResultado(resultados);
        }

        private static void CalcularMediaAlunos(List<ResultadoModel> resultados, List<AlunoModel> alunos)
        {
            foreach (var item in alunos)
            {
                var media = CalcularNotas(item.Notas);

                ResultadoModel resultado = new()
                {
                    Nome = item.Nome,
                    Media = media
                };

                resultados.Add(resultado);
            }
        }

        private static void MostraResultado(List<ResultadoModel> resultado)
        {
            IEnumerable<ResultadoModel> resultadoOrdenado = resultado.OrderByDescending(x => x.Media);

            decimal mediaGeral = CalcularNotas(resultado.Select(x => x.Media).ToArray());

            ResultadoModel? melhorMedia = resultadoOrdenado.FirstOrDefault();

            Console.WriteLine($"Media geral: {mediaGeral:0.00}");
            Console.WriteLine($"Melhor média: {melhorMedia?.Nome} ({melhorMedia?.Media.ToString("0.00")})");

            foreach (var item in resultadoOrdenado)
            {
                Console.WriteLine($"{item.Nome}: {item.Media:0.00}");
            }

        }

        private static decimal CalcularNotas(decimal[] notas)
        {
            decimal media = 0;

            foreach (var item in notas)
            {
                media += item;
            }

            media /= notas.Length;
            return media;
        }
    }
}