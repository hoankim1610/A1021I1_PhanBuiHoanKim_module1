import {IAccount} from '../account/IAccount';

export interface ICustomer {
  customerId?: number;
  customerName?: string;
  customerPhone?: string;
  customerEmail?: string;
  customerImage?: string;
  customerAddress?: string;
  customerAccountId?: IAccount;
}
