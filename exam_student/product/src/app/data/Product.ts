import {Category} from "./Category";

export interface Product {
  id?: number;
  name?: string;
  price?: number;
  quantity?: number;
  status?: string;
  category?: Category;
}
