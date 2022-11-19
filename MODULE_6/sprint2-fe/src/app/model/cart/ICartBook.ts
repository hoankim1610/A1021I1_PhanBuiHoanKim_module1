import {ICart} from './ICart';
import {IBook} from '../book/IBook';


export interface ICartBook {
  cartBookId?: number;
  cartId?: ICart;
  bookId?: IBook;
}
