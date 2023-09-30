import { Directive, ElementRef, Input, OnInit } from '@angular/core';

type AppButtonType = 'primary' | 'secondary' | 'tertiary';

@Directive({
  selector: '[appButton]'
})
export class AppButtonDirective implements OnInit {

  @Input()
  public conectaButton?: AppButtonType = 'primary';

  @Input()
  public ghost?: boolean;

  constructor(
    private el: ElementRef
  ) { }

  ngOnInit(): void {
    this.applyStyles();
  }

  private applyStyles(): void {
    this.el.nativeElement.className = (`app-button ${this.conectaButton || 'primary'} ${this.ghost ? 'ghost' : ''}`);
  }

}