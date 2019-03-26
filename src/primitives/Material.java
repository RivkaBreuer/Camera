package primitives;

public class Material {
	
	
	public double kd;
	public double ks;
	public int nShininess;
	public double kr;
	public double kt;

	
	// ***************** Constructors ********************** // 

	
	public Material(double kd, double ks,int nShininess,double kr, double kt) {
		this.kd = kd;
		this.ks = ks;
		this.nShininess = nShininess;
		this.kr = kr;
		this.kt = kt;


		
	}
	
	public Material() {
		this.kd = 1;
		this.ks = 1;
		this.nShininess=1;
		this.kr = 0.1;
		this.kt = 0.1;
	}
	
	public Material(Material other) {
		this.kd = other.kd;
		this.ks = other.ks;
		this.nShininess = other.nShininess;
		this.kr = other.kr;
		this.kt = other.kt;
	}


	
	// ***************** Getters/Setters ********************** // 
	
		public double getKr() {
		return kr;
	}

	public void setKr(double kr) {
		this.kr = kr;
	}

	public double getKt() {
		return kt;
	}

	public void setKt(double kt) {
		this.kt = kt;
	}

		public double getKd() {
		return kd;
	}

	public void setKd(double kd) {
		this.kd = kd;
	}

	public double getKs() {
		return ks;
	}

	public void setKs(double ks) {
		this.ks = ks;
	}
	

    public int getnShininess() {
		return nShininess;
	}

	public void setnShininess(int nShininess) {
		this.nShininess = nShininess;
	}


	
	// ***************** Administration  ******************** // 



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Material other = (Material) obj;
	if (Double.doubleToLongBits(kd) != Double.doubleToLongBits(other.kd))
		return false;
	if (Double.doubleToLongBits(ks) != Double.doubleToLongBits(other.ks))
		return false;
	if (nShininess != other.nShininess)
		return false;
	return true;
}

@Override
public String toString() 
{
	return "("+ "kd" + this.kd + "ks" + this.ks + "nShininess" + this.nShininess+ "kr" + this.kr + "kt" + this.kt + ")";

}
//***************** Operations ******************** //		



	
}
