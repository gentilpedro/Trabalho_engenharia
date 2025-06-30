
class Carro {
  constructor() {
    this.tipo = "Carro comum";
  }

  dirigir() {
    console.log(`Dirigindo um ${this.tipo}`);
  }
}

class Moto {
  constructor() {
    this.tipo = "Moto comum";
  }

  dirigir() {
    console.log(`Pilotando uma ${this.tipo}`);
  }
}

const tipoVeiculo = "carro"; 
let veiculo;

if (tipoVeiculo === "carro") {
  veiculo = new Carro();
} else if (tipoVeiculo === "moto") {
  veiculo = new Moto();
}

veiculo.dirigir();
