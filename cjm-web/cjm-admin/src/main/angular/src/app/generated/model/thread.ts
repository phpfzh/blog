import {Tag} from "./Tag";

export interface Thread {
  subject: string;
  fid:number;
  content: string;
  threadtype:number;
  dateline?: string;
  views?: number;
  threadData?: string;
  fname?: string;
  coverimg?: string;
  replies?: number;
  listtags?:Tag;
  username?:string;
  headurl?:string;
  tags?:string;
  usesig?:string;
  id?:number;
 }
