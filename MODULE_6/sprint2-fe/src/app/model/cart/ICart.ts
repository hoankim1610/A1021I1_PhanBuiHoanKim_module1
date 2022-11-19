import {IAccount} from '../account/IAccount';

export interface ICart {
  cartId?: number;
  cartCode?: string;
  cartQuantity?: number;
  cartTotalMoney?: number;
  cartPurchaseDate?: string;
  cartStatus?: boolean;
  cartAccountId?: IAccount;
}
