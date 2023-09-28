import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'taxId'
})
export class TaxIdPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
