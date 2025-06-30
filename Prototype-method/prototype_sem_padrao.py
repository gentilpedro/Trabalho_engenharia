# sem_prototype.py

class Robo:
    def __init__(self, nome, tipo, armas):
        self.nome = nome
        self.tipo = tipo
        self.armas = armas  # Lista de armas (objeto composto)

    def exibir(self):
        print(f"Robo: {self.nome} | Tipo: {self.tipo} | Armas: {', '.join(self.armas)}")


# Criando robôs "do zero", repetindo código
robo1 = Robo("Titan", "Combate", ["Canhão", "Míssil"])
robo2 = Robo("Titan", "Combate", ["Canhão", "Míssil"])  # Código duplicado

# E se quisermos 10 robôs iguais? Teremos que repetir ou usar laços manualmente.

robo1.exibir()
robo2.exibir()
