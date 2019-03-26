package primitives;

public class Coordinate {
	
	private double coordinate;
	
// ***************** Constructors ********************** // 
	
public Coordinate() {
	this.coordinate = 0;
}

public Coordinate(double coordinate) {
	this.coordinate = coordinate;
}


public Coordinate(Coordinate other) {
	this.coordinate = other.coordinate;
}

// ***************** Getters/Setters ********************** // 

public double getCoordinate() {
	return coordinate;
}

public void setCoordinate(double coordinate) {
	this.coordinate = coordinate;
}

// ***************** Administration  ******************** // 
@Override
public String toString() {
	return ""+ coordinate;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Coordinate other = (Coordinate) obj;
	return this.coordinate == other.coordinate;
}


// ***************** Operations ******************** // 
public Coordinate add(Coordinate c){
	double x = this.coordinate +  c.coordinate;
	return new Coordinate(x);
}

public Coordinate substrct(Coordinate c){
	double x = this.coordinate -  c.coordinate;
	return new Coordinate(x);
}



}
