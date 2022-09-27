import {Instructor} from "./Instructor";

export interface Student {
  id?: number;
  name?: string;
  group?: string;
  topic?: string;
  instructor?: Instructor
  email?: string;
  phone?: string;
}
