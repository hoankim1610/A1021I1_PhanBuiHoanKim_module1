import {IAccount} from '../account/iaccount';

export interface ICustomer {
  customerId?: number;
  customerName?: string;
  customerPhone?: string;
  customerEmail?: string;
  customerAddress?: string;
  customerAccountId?: IAccount;
}
