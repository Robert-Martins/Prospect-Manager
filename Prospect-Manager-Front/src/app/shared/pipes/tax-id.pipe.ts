import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'taxId'
})
export class TaxIdPipe implements PipeTransform {

  transform(value: string): string {
    const cleanedValue = value.replace(/\D/g, '');

    if (cleanedValue.length === 11)
      return this.transformCpf(cleanedValue);
    else if (cleanedValue.length === 14)
      return this.transformCnpj(cleanedValue);
    
    return value;
  }

  private transformCpf(cleanedValue: string): string {
    return cleanedValue.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');
  }

  private transformCnpj(cleanedValue: string): string {
    return cleanedValue.replace(/(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})/, '$1.$2.$3/$4-$5');
  }

}
