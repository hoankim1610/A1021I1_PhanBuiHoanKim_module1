import {ICategory} from './ICategory';
import {IAuthor} from './IAuthor';
import {IPromotion} from './IPromotion';


export interface IBook {
  bookId?: number;
  bookCode?: string;
  bookName?: string;
  bookImage?: string;
  bookContent?: string;
  bookPrice?: number;
  bookTranslator?: string;
  bookTotalPage?: number;
  bookSize?: string;
  bookPublishDate?: string;
  bookQuantity?: number;
  bookFlag?: boolean;
  bookPublisher?: string;
  categoryId?: ICategory;
  bookAuthorId?: IAuthor;
  bookPromotionId?: IPromotion;
}
