import {FacilitiesType} from "./facilititiesType";

export interface Facilities {
  id?: number;
  name?: string;
  area?: number;
  cost?: number;
  maxPeople?: number;
  rentalType?: string;
  facilityType?: FacilitiesType;
  standardRoom?: string;
  poolArea?: number;
  floor?: number;
  image?: string;

}
