package com.cubo2d.c3;

public class calculos {

	public double E = 1.0E-5D;
	private double A;
	private double DI;
	private double M;
	private double Q0;
	private double V;
	private double V0;
	private double Y;
	private double aux;
	private double aux2;
	private double aux3;
	private double ci;
	private double cs;
	private double d;
	private double di;
	private String material = new String();
	private int por;
	private double Q;
	private double s;
	private double tet = 3.14D;
	private double teta;

	public void calcular() {

		
		s = (cs - ci) / DI;
		por = 1000;
		teta = tet;

		if ((Q > 0.0D) && (this.s > 0.0D)) {

			calcular_diametro();
			Q0 = calculo_Q0();
		}

		V0 = (0.397D / this.M * Math.pow(d, 0.6666666666666666D) * Math.pow(s, 0.5D));

		calculo_Y();

		double d1 = teta;
		double d2 = Math.sin(teta);
		double d3 = Math.pow(d, 2.0D);
		
		V = Q / (1000.0D * (0.125D * (d1 - d2) * d3));
		
		
		imprimir();

	}

	public void calculo_Y() {
		do {
			tet = teta;
			teta = (Math.sin(tet) + 8.0D / Math.pow(this.d, 2.0D) * Math.pow(
					this.Q / 1000.0D * (M / Math.pow(s, 0.5D)) * Math.pow(tet * d / 2.0D, 0.6666666666666666D), 0.6D));
		} while (Math.abs(tet - teta) / tet > E);
		Y = (d / 2.0D - d / 2.0D * Math.cos(teta / 2.0D));
	}

	public void calcular_diametro() {

		d = 0.2D;
		Q0 = calculo_Q0();
		if (Q0 * this.por < Q) {
			d = 0.25D;
			Q0 = calculo_Q0();
			if (Q0 * this.por < this.Q) {
				d = 0.3D;
				Q0 = calculo_Q0();
				if (Q0 * this.por < this.Q) {
					d = 0.4D;
					Q0 = calculo_Q0();
					if (Q0 * this.por < this.Q) {
						d = 0.5D;
						Q0 = calculo_Q0();
						if (Q0 * this.por < this.Q) {
							d = 0.6D;
							Q0 = calculo_Q0();
							if (Q0 * this.por < this.Q) {
								d = 0.7D;
								Q0 = calculo_Q0();
								if (Q0 * this.por < this.Q) {
									d = 0.9D;
									Q0 = calculo_Q0();
									if (Q0 * this.por < this.Q) {
										d = 1.0D;
										Q0 = calculo_Q0();
									}
								}
							}
						}
					}
				}
			}
		}

	}

	public double calculo_Q0() {
		return 0.312D / M * Math.pow(d, 2.6666666666666665D) * Math.pow(s, 0.5D);

	}
	
	
	public void imprimir(){
		
		System.out.println("CS= "+cs);
		System.out.println("CI= "+ci);
		System.out.println("dist= "+DI);
		System.out.println("pent= "+s);
		System.out.println("M= "+M);
		System.out.println("Q= "+Q);
		System.out.println("Q0= "+Q0);
		System.out.println("V= "+V);
		System.out.println("V0= "+V0);
		System.out.println("Y= "+Y);
		
	}

	public double getA() {
		return A;
	}

	public void setA(double a) {
		A = a;
	}

	public double getDI() {
		return DI;
	}

	public void setDI(double dI) {
		DI = dI;
	}

	public double getM() {
		return M;
	}

	public void setM(double m) {
		M = m;
	}

	public double getQ0() {
		return Q0;
	}

	public void setQ0(double q0) {
		Q0 = q0;
	}

	public double getV() {
		return V;
	}

	public void setV(double v) {
		V = v;
	}

	public double getV0() {
		return V0;
	}

	public void setV0(double v0) {
		V0 = v0;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		Y = y;
	}

	public double getAux() {
		return aux;
	}

	public void setAux(double aux) {
		this.aux = aux;
	}

	public double getAux2() {
		return aux2;
	}

	public void setAux2(double aux2) {
		this.aux2 = aux2;
	}

	public double getAux3() {
		return aux3;
	}

	public void setAux3(double aux3) {
		this.aux3 = aux3;
	}

	public double getCi() {
		return ci;
	}

	public void setCi(double ci) {
		this.ci = ci;
	}

	public double getCs() {
		return cs;
	}

	public void setCs(double cs) {
		this.cs = cs;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	public double getDi() {
		return di;
	}

	public void setDi(double di) {
		this.di = di;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getPor() {
		return por;
	}

	public void setPor(int por) {
		this.por = por;
	}

	public double getQ() {
		return Q;
	}

	public void setQ(double Q) {
		this.Q = Q;
	}

	public double getS() {
		return s;
	}

	public void setS(double s) {
		this.s = s;
	}

}
