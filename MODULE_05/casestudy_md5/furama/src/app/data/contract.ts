import {Customer} from "./customer";

export interface Contract {
  id?: number;
  customer?: Customer;
  startDay?: string;
  endDay?: string;
  deposit?: number;
  total?: number;
}
